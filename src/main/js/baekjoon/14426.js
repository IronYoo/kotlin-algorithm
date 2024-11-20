// const inputs = require('fs').readFileSync('./example.txt').toString().split('\n')
const inputs = require('fs').readFileSync('/dev/stdin').toString().split('\n')

let [n,m] = inputs[0].split(' ')
n = parseInt(n)
m = parseInt(m)

const arr = []
for (let i = 1; i < 1+n; i ++) {
    // console.log(i)
    arr.push(inputs[i])
}
// console.log(arr)

const subArr = []
for (let i = n+1; i <= n+m; i ++) {
    subArr.push(inputs[i])
}
// console.log(subArr)

let cnt = 0
for (let s of subArr) {
    for (let a of arr) {
        if (a.startsWith(s)) {
            cnt ++
            break
        }
    }
}
console.log(cnt)