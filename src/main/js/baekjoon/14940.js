// const inputs = require('fs').readFileSync('./example.txt').toString().split('\n')
const inputs = require('fs').readFileSync('/dev/stdin').toString().split('\n')

const [n,m] = inputs.shift().split(" ").map(it => parseInt(it))
const grid = inputs.map(row => row.split(" ").map(it => parseInt(it)))
const visited = Array.from({length: n}, () => Array(m).fill(false))
const answer = Array.from({length: n}, () => Array(m).fill(-1))

let start
for (let i=0; i<n; i++) {
    for (let j = 0; j < m; j++) {
        if (grid[i][j] === 2) {
            start = [i,j]
        }
    }
}

let q = [start]
let d = [
    [-1, 0],
    [1, 0],
    [0, -1],
    [0, 1]
]

let dist = 0
while (q.length) {
    const newQ = []
    for (const target of q) {
        const [x,y] = target
        answer[x][y] = dist

        for (const [dx, dy] of d) {
            const [nx, ny] = [x+dx, y+dy]
            if (nx<n && ny<m && nx>=0 && ny>=0 && !visited[nx][ny]) {
                if (grid[nx][ny] === 1) {
                    visited[nx][ny] = true
                    newQ.push([nx, ny])
                } else if (grid[nx][ny] === 0) {
                    visited[nx][ny] = true
                    answer[nx][ny] = 0
                }
            }
        }
    }
    q = newQ
    dist ++
}

answer.forEach(it => console.log(it.join(" ")))