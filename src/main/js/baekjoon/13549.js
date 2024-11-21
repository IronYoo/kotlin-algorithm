// const inputs = require('fs').readFileSync('./example.txt').toString().split('\n')
const inputs = require('fs').readFileSync('/dev/stdin').toString().split('\n')

const n = parseInt(inputs[0])
const grid = []
for (const i of inputs.slice(1, inputs.length)) {
    grid.push(i.split(''))
}
// console.log(grid)

const dir = [
    [-1, 0],
    [1, 0],
    [0, -1],
    [0, 1]
]

function bfs1(grid, n) {
    const visited = Array.from({length: n}, () => Array(n).fill(false))
    const mappers = {
        'R': ['R', 'G'],
        'G': ['R', 'G'],
        'B': ['B']
    }

    let cnt = 0
    for (let i = 0; i < n; i ++) {
        for (let j = 0;  j< n; j ++) {
            if (visited[i][j] === false) {
                cnt++
                const q = []
                q.push([i, j])

                const mapper = mappers[grid[i][j]]

                while (q.length) {
                    const [x,y] = q.shift()

                    for (const [dx, dy] of dir) {
                        const [nx, ny] = [x+dx, y+dy]
                        if (nx >=0 && nx < n && ny >=0 && ny < n && !visited[nx][ny]) {
                            if (mapper.includes(grid[nx][ny])) {
                                q.push([nx, ny])
                                visited[nx][ny] = true
                            }
                        }
                    }
                }
            }
        }
    }

    return cnt
}


function bfs2(grid, n) {
    const visited = Array.from({length: n}, () => Array(n).fill(false))
    const mappers = {
        'R': ['R'],
        'G': ['G'],
        'B': ['B']
    }

    let cnt = 0
    for (let i = 0; i < n; i ++) {
        for (let j = 0;  j< n; j ++) {
            if (visited[i][j] === false) {
                cnt++
                const q = []
                q.push([i, j])

                const mapper = mappers[grid[i][j]]

                while (q.length) {
                    const [x,y] = q.shift()

                    for (const [dx, dy] of dir) {
                        const [nx, ny] = [x+dx, y+dy]
                        if (nx >=0 && nx < n && ny >=0 && ny < n && !visited[nx][ny]) {
                            if (mapper.includes(grid[nx][ny])) {
                                q.push([nx, ny])
                                visited[nx][ny] = true
                            }
                        }
                    }
                }
            }
        }
    }

    return cnt
}


const cnt1 = bfs1(grid, n)
// console.log(cnt1)
const cnt2 = bfs2(grid, n)
// console.log(cnt2)

console.log(`${cnt2} ${cnt1}`)