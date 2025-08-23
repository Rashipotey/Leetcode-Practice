import java.lang.Iterable;
class Solution {
    public String simplifyPath(String path) {
        Deque<String> strS=new ArrayDeque<>();
        StringBuilder sb=new StringBuilder();
        for(String dir:path.split("/")){
            if(dir.equals(".") || dir.equals("")) continue;
            else if(dir.equals("..")){
                if(!strS.isEmpty()) strS.pop();
            }else strS.push(dir);
        }
        Iterator<String> it=strS.descendingIterator();
        while(it.hasNext()){
            sb.append("/").append(it.next());
        }
        return sb.length()>0?sb.toString():"/";
    }
}