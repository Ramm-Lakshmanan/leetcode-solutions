class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        d={'2':"abc",'3':"def",'4':"ghi",'5':"jkl",'6':"mno",'7':"pqrs",'8':"tuv",'9':"wxyz"}
        l=[]
        first=digits[0]
        for i in range(len(d[first])):
            l.append(d[first][i])
        for i in range(1,len(digits)):
            j=0
            length=len(l)
            while(j<length):
                start=l.pop(0)
                for k in range(0,len(d[digits[i]])):
                    l.append(start+d[digits[i]][k])
                j+=1
        return l;
                