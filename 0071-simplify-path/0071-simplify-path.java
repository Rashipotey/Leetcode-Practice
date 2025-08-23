class Solution {
    public String simplifyPath(String path) {
        Stack<String> strS=new Stack<>();
        String[] splitStr=path.split("/");
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<splitStr.length;i++){
            if(splitStr[i].equals(".") || splitStr[i].equals("")) continue;
            else if(splitStr[i].equals("..")){
                if(!strS.isEmpty()) strS.pop();
            }else strS.push(splitStr[i]);
        }
        for(String s:strS){
            sb.append("/"+s);
        }
        return sb.length()>0?sb.toString():"/";
    }
}