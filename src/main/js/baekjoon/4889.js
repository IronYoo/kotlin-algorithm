// const inputs = require('fs').readFileSync('./example.txt').toString().split('\n')
const inputs = require('fs').readFileSync('/dev/stdin').toString().split('\n')

for (let i = 0; i<inputs.length - 1; i ++) {
    const str = inputs[i].split('')

    let count = 0
    const stack = []

    for (let s of str) {
        if (s === "{") stack.push("{")
        else {
            if (!stack.length) {
                stack.push("{")
                count ++
            } else {
                stack.pop()
            }
        }
    }

    console.log(`${i+1}. ${count + stack.length / 2}`)
}

