General Structure

Greedy algorithm are used to find the optimal solition.


    getOptimal(Item[] array, int n) {
   
           1. Initialize result = 0;
           2. while (all item are not considered) {
                i = selectAnItem();
                if(feasable(i)) {
                    res = res + i;
                }
             }
           3. return result;
    }