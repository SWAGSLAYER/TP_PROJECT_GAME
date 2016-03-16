width = irandom(2)+2
turn = argument0
build_turn = 0
i=0
a=0

if turn = 0{//left
    xx=0
    yy=irandom((room_height/64))*64 - 64
    for(xx = 0;xx<room_width;xx+=64){
        yy += irandom(2)*64 - 64;
        if !collision_rectangle(xx,yy,xx+64,yy+64,obj_nonsolid,false,true){
            if yy < room_height/2{
                for(i=0;i<width*64;i+=64){
                    a = instance_create(xx,yy+i,obj_nonsolid) a.image_index = 2 a.image_speed = 0
                }
            }
            if yy >= room_height/2{
                for(i=0;i<width*64;i+=64){
                    a = instance_create(xx,yy-i,obj_nonsolid) a.image_index = 2 a.image_speed = 0
                }
            }
        }
    }
}
if turn = 1{//right
    xx=room_width-64;
    yy=irandom((room_height/64)*64) - 64
}
if turn = 2{//up
    xx=irandom((room_width/64)*64) - 64
    yy=0
}
if turn = 3{//down
    xx=irandom((room_width/64)*64) - 64
    yy=room_height-64
}

