// IN CPP

//public class BackspaceStringCompare {
//    bool backspaceCompare(string S, string T) {
//        int n = S.length();
//        int sz = 0;
//        for(int i = 0;i<n;i++) {
//            if(S[i] == '#'){
//                if(sz > 0)
//                    sz--;
//            }
//            else
//                S[sz++] = S[i];
//        }
//        int z = 0;
//        n = T.length();
//        for(int i = 0;i<n;i++) {
//            if(T[i] == '#'){
//                if(z > 0)
//                    z--;
//            }
//            else
//                T[z++] = T[i];
//        }
//        if(sz != z)
//            return false;
//        for(int i=0;i<sz;i++){
//            if(S[i] != T[i])
//                return false;
//        }
//        return true;
//    }
//}
