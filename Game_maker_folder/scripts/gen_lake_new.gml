length = irandom(6)+10;
width = irandom(6)+5;
i=0
j=0
xx=0
yy=0
yy_top = 0
yy_bot = 0
up = false
down = false

//do{
    xx = irandom(room_width/64)*64
    yy = irandom(room_height/64)*64
    start_xx = xx
    start_yy = yy
    yy_top = yy
    yy_bot = yy
//}until(!place_meeting(xx,yy,obj_nonsolid))

max_top = yy - 64*(width div 2)
max_bot = yy + 64*(width div 2)

for(i=0;i<length*64;i+=64){
    if up = true and yy_top < yy{
        yy_top += irandom(2)*64
    }
    else if yy_top = max_top{
        up = true
    }
    else if yy_top > max_top{
        yy_top -= irandom(2)*64
    }
    
    if down = true and yy_bot > yy{
        yy_bot -= irandom(2)*64
    }
    else if yy_bot = max_bot{
        down = true
    }
    else if yy_bot > max_bot{
        yy_bot += irandom(2)*64
    }
    for(j = yy_top;j<yy_bot;j+=64){
        a = instance_create(xx+i,j,obj_nonsolid) a.image_index = 2 a.image_speed = 0
    }
}




