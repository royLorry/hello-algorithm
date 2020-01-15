/**
 * @param {string} preorder
 * @return {boolean}
 */
var isValidSerialization = function(preorder) {
    if(preorder=="#") return true;
    let pre = preorder.split(",");
    let stack=[];
    let count =0; 
    for(let i=0;i<pre.length;++i){
        stack.push(pre[i]);
        if(pre[i]=="#") count++;
        else count=0;
        while(count==2){
            if(stack.length==2) return false;
            else if(stack.length==3) return i==pre.length-1; 
            else {
                for(let j=0;j<3;j++) stack.pop();
                let flag = stack[stack.length-1]=="#";
                stack.push("#");
                if(flag) count=2;
                else count=1;               
            }
        }
    }
    return stack.length==0;
};
