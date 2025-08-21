class Solution {
    public int totalFruit(int[] fruits) {
        int left=0;
        int maxLen=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int right=0;right<fruits.length;right++){
            map.put(fruits[right],map.getOrDefault(fruits[right],0)+1);
            while(map.size()>2){
                int fruit=fruits[left];
                  map.put(fruit, map.get(fruit) - 1);
                if (map.get(fruit) == 0) {
                    map.remove(fruit);
                }
                left++; // shrink
            }

            // 3. Update answer
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
            }
        }
    