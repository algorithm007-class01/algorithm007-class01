/**
 * @param {number[]} commands
 * @param {number[][]} obstacles
 * @return {number}
 */
var robotSim = function(commands, obstacles) {
    let dx = [0,1,0,-1];
    let dy = [1,0,-1,0];
    let di = 0;
    let endX = 0;
    let endY = 0;
    let res = 0;
    let hashObstacle = {};
    for(let i = 0;i<obstacles.length;i++){
        hashObstacle[obstacles[i][0]+'-'+obstacles[i][1]] = true;
    }
    for(let i = 0;i<commands.length;i++){
        if(commands[i] == -2){
            di = (di+3)%4;
        }else if(commands[i] == -1){
            di = (di+1)%4;
        }else{
            let step = commands[i];
            while(step>0){
                let nextX = endX + dx[di];
                let nextY = endY + dy[di];
                if(hashObstacle[nextX+'-'+nextY]){
                    break;
                }
                endX = nextX;
                endY = nextY;
                res = Math.max(res,endX*endX+endY*endY);
                step--;
            }
        }
    }
    return res;
};