class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        for (String cpdomain : cpdomains) {
            splitCount(cpdomain);
        }
        List<String> ans = new ArrayList<>(countMap.size());
        for(Map.Entry<String, Integer> entry : countMap.entrySet()) {
            ans.add(entry.getValue().toString() + " " + entry.getKey());
        }
        return ans;
    }

    private void splitCount(String domain) {
        String[] source = domain.split(" ");
        Integer count = Integer.parseInt(source[0]);
        

        String[] ds = source[1].split("\\.");
        
        String suffix = "";
        for (int i=ds.length-1; i >= 0; i--) {
            if (i == ds.length-1) {
                suffix = ds[i] + suffix;
            } else {
                suffix = ds[i] + "."+ suffix;
            }

            Integer old = 0;
            if (countMap.containsKey(suffix)) {
                old = countMap.get(suffix);
            }
            old += count;
            
            
            countMap.put(suffix, old);
        }
    }


    private Map<String,Integer> countMap = new HashMap<>(300);
}
