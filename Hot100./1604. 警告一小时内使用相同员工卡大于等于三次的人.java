class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        int len = keyTime.length;
        HashMap<String, List<Integer>> timeMap = new HashMap<>();
        List<String> res = new ArrayList();
        for(int i = 0 ; i < len ; i++)
        {
            String name = keyName[i];
            timeMap.putIfAbsent(name, new ArrayList());
            String time = keyTime[i];
            int hours = Integer.parseInt(time.split(":")[0]);
            int minuties = Integer.parseInt(time.split(":")[1]);
            timeMap.get(name).add(60 * hours + minuties);
        }
        Set<String> nameSet = timeMap.keySet();
        for(String name : nameSet){
            List<Integer> time = timeMap.get(name);
            Collections.sort(time);
            for(int i = 0 ; i < time.size() - 2; i++)
            {
                int first = time.get(i);
                int second = time.get(i + 1);
                int third = time.get(i + 2);
                if(third - first <= 60 && second - first <= 60){
                    res.add(name);
                    break;
                }
            }
        }
        Collections.sort(res);
        return res;
    }
}
