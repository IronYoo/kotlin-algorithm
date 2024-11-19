// const inputs = require('fs').readFileSync('./example.txt').toString().split('\n')
const inputs = require('fs').readFileSync('/dev/stdin').toString().split('\n')

const [a,b] = inputs[0].split(' ')

const comb = []
function dfs(left, list) {
    if (left?.length === 0) {
        comb.push(parseInt(list.join('')))
        return
    }

    for (let i = 0; i < left.length; i ++) {
        const newLeft = [...left.slice(0, i), ...left.slice(i+1, left.length)]
        const newList = [...list]
        if (!(list.length === 0 && left[i] === '0')) {
            newList.push(left[i])
            dfs(newLeft, newList)
        }
    }
}

dfs(a.split(''), [])

let answer = -1
// console.log(answer)
const filtered = comb.filter(it => it < parseInt(b))
// console.log(filtered)
filtered.forEach(it => answer = Math.max(answer, it))

console.log(answer)