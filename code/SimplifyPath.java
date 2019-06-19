class Solution {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0)
            return "/";
        
        String result = "";
            
        for (String folder: path.split("/")) {
            if (folder.equals(".") || folder.equals("")) {
                continue;
            } else if (folder.equals("..")) {
                int index = result.lastIndexOf('/');
                if (index != -1)
                    result = result.substring(0, index);
            } else {
                result = result + "/" + folder;
            }
        }
        
        if (result.length() == 0)
            result = "/";
        
        return result;
    }
}