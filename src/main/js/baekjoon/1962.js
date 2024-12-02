const inputs = require('fs').readFileSync('./example.txt').toString().split('\n')
// const inputs = require('fs').readFileSync('/dev/stdin').toString().split('\n')

const [n,m] = inputs.shift().split(" ").map(it => parseInt(it))
const grid = inputs.map(row => row.split(" ").map(it => parseInt(it)))

// console.log(n,m)
// console.log(grid)

const visited = Array.from({length: n}, () => Array(m).fill(false))

function bfs(q) {
    let cnt = 1

    let d = [
        [0, 1],
        [0, -1],
        [1, 0],
        [-1, 0]
    ]

    while (q.length) {
        const [x,y] = q.shift()

        for (const [dx, dy] of d) {
            const [nx, ny] = [x+dx, y+dy]
            if (nx>=0 && nx<n && ny>=0 && ny<m && !visited[nx][ny] && grid[nx][ny] === 1) {
                visited[nx][ny] = true
                cnt++
                q.push([nx,ny])
            }
        }
    }

    return cnt
}

let count = 0
let max = -1e9
for (let i=0; i<n; i++) {
    for (let j=0; j<m; j++) {
        if (grid[i][j] === 1 && !visited[i][j]) {
            count ++
            visited[i][j] = true

            max = Math.max(max, bfs([[i,j]]))
        }
    }
}

console.log(count)
console.log(max)
