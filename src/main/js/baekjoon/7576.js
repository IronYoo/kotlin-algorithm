// const inputs = require('fs').readFileSync('./example.txt').toString().split('\n')
const inputs = require('fs').readFileSync('/dev/stdin').toString().split('\n')

const [m,n] = inputs[0].split(' ').map(it => parseInt(it))

const visited = Array.from({length: n}, () => Array(m).fill(false))
// console.log(visited)

const grid = []

let q = []
for (let i = 1; i <= n; i++) {
    grid.push(inputs[i].split(' ').map((it, index) => {
        if (it === '1') {
            q.push([i-1, index])
            visited[i-1][index] = true
        }
        return parseInt(it)
    }))
}
// console.log(grid)

let count = 0
const dir = [
    [0, 1],
    [0, -1],
    [1, 0],
    [-1, 0],
]
while (q.length > 0) {
    // console.log(q)
    const newQ = [...q]
    q = []
    // console.log('newQ=', newQ)

    while (newQ.length > 0) {
        const [x,y] = newQ.shift()
        grid[x][y] = 1

        for (let [dx,dy] of dir) {
            const nx = x+dx
            const ny = y+dy

            // console.log(nx,ny)

            if (nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] === 0 && visited[nx][ny] === false) {
                q.push([nx, ny])
                visited[nx][ny] = true
            }
        }
    }
    count++
}

// console.log(count)
// console.log(grid)

function check(box) {
    for (let row of box) {
        for (let col of row) {
            if (col === '0') return false
        }
    }

    return true
}

check(grid) ? console.log(count - 1) : console.log(-1)
