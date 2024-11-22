// const inputs = require('fs').readFileSync('./example.txt').toString().split('\n')
const inputs = require('fs').readFileSync('/dev/stdin').toString().split('\n')

const set = new Set()

const n = parseInt(inputs[0])

const answer = []
for (let i = 1 ; i <= n; i++ ) {
    const seperated = inputs[i].split(' ')

    // console.log(seperated)
    const sepIndex = seperated.findIndex(it => !set.has(it[0].toLowerCase()))
    // console.log(`sepIndex=${sepIndex}`)
    // console.log(set)
    if (sepIndex >= 0) {
        const str = seperated.map((it, index) => {
            if(index === sepIndex) {
                const newStr = it.split('')
                const first = newStr.shift()
                set.add(first.toLowerCase())
                return `[${first}]${newStr.join('')}`
            }
            return it
        }).join(' ')
        answer.push(str)
        continue
    }

    const splited = inputs[i].split('')
    const splitIndex = splited.findIndex(it => it !== ' ' && !set.has(it.toLowerCase()))
    // console.log(`splitIndex=${splitIndex}`)
    if (splitIndex >= 0) {
        const str = splited.map((it, index) => {
            if (index === splitIndex) {
                set.add(it.toLowerCase())
                return `[${it}]`
            }
            return it
        }).join('')
        answer.push(str)
        continue
    }

    answer.push(inputs[i])
}

answer.forEach(it => console.log(it))
