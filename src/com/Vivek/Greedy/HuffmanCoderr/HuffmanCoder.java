package com.Vivek.Greedy.HuffmanCoderr;

import com.Vivek.Greedy.HuffmanCoderr.Heap;

import java.util.HashMap;
import java.util.Map;

public class HuffmanCoder {
    HashMap<Character, String> encoder;
    HashMap<String, Character> decoder;

    private class Node implements Comparable <Node>{
        Character data;
        int frequency;
        Node left;
        Node right;

        public Node(Character data, int frequency){
            this.data = data;
            this.frequency = frequency;
            this.left = null;
            this.right = null;
        }

        @Override
        public int compareTo(Node obj){
            return obj.frequency - this.frequency;
        }
    }

    public HuffmanCoder(String feeder) throws Exception {
        HashMap<Character, Integer> frequencyMap = new HashMap<>();

        for(int i = 0; i < feeder.length(); i++){
            frequencyMap.put(feeder.charAt(i), frequencyMap.getOrDefault(feeder.charAt(i), 1) + 1);
        }

        Heap<Node> minHeap = new Heap<>();

        for(Map.Entry<Character, Integer> entry: frequencyMap.entrySet()){
            Node node = new Node(entry.getKey(), entry.getValue());
            minHeap.insert(node);
        }

        while(minHeap.size() != 1){
            Node first = minHeap.remove();
            Node second = minHeap.remove();

            Node newNode = new Node('\0', first.frequency + second.frequency);
            minHeap.insert(newNode);
        }

        Node ft = minHeap.remove();

        this.encoder = new HashMap<>();
        this.decoder = new HashMap<>();

        this.initEncoderDecoder(ft, "");
    }

    private void initEncoderDecoder(Node node, String osf){
        if(node == null){
            return;
        }
        if(node.left == null && node.right == null){
            this.encoder.put(node.data, osf);
            this.decoder.put(osf, node.data);
        }
        initEncoderDecoder(node.left, osf + "0");
        initEncoderDecoder(node.right, osf + "1");
    }

    public String encode(String source){
        String ans = "";

        for(int i = 0; i < source.length(); i++){
            ans = ans + encoder.get(source.charAt(i));
        }
        return ans;
    }

    public String decode(String codedString){
        String key = "";
        String ans = "";
        for(int i = 0;  i < codedString.length(); i++){
            key = key + codedString.charAt(i);
            if(decoder.containsKey(key)){
                ans = ans + decoder.get(key);
                key = "";
            }
        }
        return ans;
    }
}
