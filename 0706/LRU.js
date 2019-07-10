/**
 * @param {number} capacity
 */
var LRUCache = function(capacity) {
    this.obj={};
    this.len=capacity;
    this.arr = [];
};

/** 
 * @param {number} key
 * @return {number}
 */
LRUCache.prototype.get = function(key) {
    if(this.obj[key]){
        if(this.arr.indexOf(key)>-1){
            this.arr.splice(this.arr.indexOf(key),1);     
        }else if(this.arr.length==this.len){
            this.arr.splice(0,1);
        }
        this.arr.push(key);
        return this.obj[key];
    }else{
        return -1;
    }
};

/** 
 * @param {number} key 
 * @param {number} value
 * @return {void}
 */
LRUCache.prototype.put = function(key, value) {
    if(this.obj[key]){
       if(this.arr.indexOf(key)>-1){
            this.arr.splice(this.arr.indexOf(key),1);     
        } 
    }else if(this.arr.length==this.len){
        let last=this.arr.splice(0,1);
        delete this.obj[last];
    }
    this.arr.push(key);
    this.obj[key]=value;
};

/** 
 * Your LRUCache object will be instantiated and called as such:
 * var obj = new LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */
