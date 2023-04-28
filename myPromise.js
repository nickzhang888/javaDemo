// 1.promise状态的不可变性
// 2.promise支持异步,采用setTimeout
// 3.promise中采用.then的链式调用,原理是返回新的promise,而不是返回自身
export default class myPromise {
    constructor(executor) {
        // 参数校验，只能传递函数
        if (typeof executor !== 'function') {
            throw (`Promise resolver ${executor} is not a function`);
        }
        this.success = null;
        this.fail = null;
        this.state = "pending";
        this.onResolvedCallbacks = [];
        this.onRejectedCallbacks = [];
        // 先定义resolve和reject函数
        let resolve = (value) => {
            if (this.state == "pending") {
                this.state = "fulfilled";
                this.success = value;
                this.onResolvedCallbacks.forEach((fn) => fn());
            }
        };
        let reject = (value) => {
            if (this.state == "pending") {
                this.state = "rejected";
                this.fail = value;
                this.onRejectedCallbacks.forEach((fn) => fn());
            }
        };
        try {
            // 执行,excutor对应myPromise里传入的函数,resolve,reject两个函数相当于这个函数里的参数
            executor(resolve, reject);

        } catch (err) {
            reject(err);
        }
    }
    then(onFulfilled, onRejected) {
        // 不是函数也让其转为函数的格式
        onFulfilled = typeof onFulfilled === "function" ? onFulfilled : (value) => value;
        onRejected = typeof onRejected === "function" ? onRejected : (err) => {
            throw err;
        };
        let promise2 = new myPromise((resolve, reject) => {
            if (this.state === "fulfilled") {
                setTimeout(() => {
                    try {
                        // 通过回调函数的方式传给实例,x为回调函数的返回值,onFulfilled(this.success)这一步已经把值传过去了,
                        let x = onFulfilled(this.success);
                        // x是onFulfilled函数里的返回值, 若没return,或者不是函数, 则返回值为undefined,但原先的值会发生值穿透,传递过来
                        // 进行深层次判断
                        resolvePromise(promise2, x, resolve, reject);
                    } catch (error) {
                        reject(error);
                    }
                }, 0);
            }
            if (this.state === "rejected") {
                setTimeout(() => {
                    try {
                        let x = onRejected(this.fail);
                        resolvePromise(promise2, x, resolve, reject);
                    } catch (error) {
                        reject(error);
                    }
                }, 0);
            }
            // 当状态state为pending时,如果跟上面一样,当存在resolve外是setTimeout时,this.success为null,
            // 所以先要把成功时的值存到数组中,然后再遍历执行
            if (this.state === "pending") {
                // onFulfilled传入到成功数组
                this.onResolvedCallbacks.push(() => {
                    setTimeout(() => {
                        try {
                            let x = onFulfilled(this.success);
                            resolvePromise(promise2, x, resolve, reject);
                        } catch (error) {
                            reject(error);
                        }
                    }, 0);
                });
                // onRejected传入到失败数组
                this.onRejectedCallbacks.push(() => {
                    setTimeout(() => {
                        try {
                            let x = onRejected(this.fail);
                            resolvePromise(promise2, x, resolve, reject);
                        } catch (error) {
                            reject(error);
                        }
                    }, 0);
                });
            }
        });
        return promise2;
    }
    catch(fn) {
        // 相当于直接走reject
        return this.then(null, fn);
    }
}

function resolvePromise(promise2, x, resolve, reject) {
    // 判断是否循环引用，自己等待自己完成，一辈子完不成
    if (x === promise2) {
        reject(new TypeError("Chaining cycle detected for promise"));
    }
    // 防止多次调用
    let called;
    if ((x != null && typeof x === "object") || typeof x === "function") {
        // 函数或者对象
        try {
            let then = x.then;
            // 如果内部还是promise,则递归调用
            if (typeof then === "function") {
                then.call(x,
                    (y) => {
                        if (called) return;
                        called = true;
                        resolvePromise(promise2, y, resolve, reject);
                    },
                    (err) => {
                        if (called) return;
                        called = true;
                        reject(err);
                    }
                );
            } else {
                //普通值
                resolve(x);
            }
        } catch (e) {
            if (called) return;
            called = true;
            reject(e);
        }
    } else {
        //普通值
        resolve(x);
    }
}
myPromise.resolve = (val) => {
    return new myPromise((resolve, reject) => {
        // 相当于执行constructor中的resolve方法
        resolve(val);
    });
};
myPromise.reject = (val) => {
    return new myPromise((resolve, reject) => {
        reject(val);
    });
};
myPromise.all = (promises) => {
    return new myPromise((resolve, reject) => {
        let count = 0;
        const result = [];
        for (let i = 0; i < promises.length; i++) {
            // 此处不直接使用resolve而使用myPromise.resolve是因为,resolve后状态就改变了,整个myPromise.all就结束了
            const promise = myPromise.resolve(promises[i]).then(res => res)
            promise.then((res) => {
                result.push(res);
                count++;
                if (count === promises.length) {
                    resolve(result);
                }
            })
                .catch((err) => {
                    reject(err);
                });
        }
    });
};
//检查自己写的promise是否正确
myPromise.deferred = function () {
    const defer = {}
    defer.promise = new myPromise((resolve, reject) => {
        defer.resolve = resolve
        defer.reject = reject
    })
    return defer
}
