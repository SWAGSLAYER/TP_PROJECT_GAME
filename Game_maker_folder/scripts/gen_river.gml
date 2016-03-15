width = irandom(2)+1
turn = irandom(3)
build_turn = 0
var ID,a,i

if turn = 0{//left
    xx=0
    yy=irandom((room_height/64)*64) - 64
    i=0
    while(i<room_width){
        if yy < room_height/2{
            for (a=0;a<width;a++){
                ID = instance_create(xx+i,yy+a*64,obj_nonsolid) ID.image_index = 2 ID.image_speed = 0
            }
        }
        else{
            for (a=0;a<width;a++){
                ID = instance_create(xx+i,yy-a*64,obj_nonsolid) ID.image_index = 2 ID.image_speed = 0
            }
        }
        i+=64
    }
}
if turn = 1{//right
    xx=room_width-64;
    yy=irandom((room_height/64)*64) - 64
    i=0
    while(i<room_width){
        if yy < room_height/2{
            for (a=0;a<width;a++){
                ID = instance_create(xx-i,yy+a*64,obj_nonsolid) ID.image_index = 2 ID.image_speed = 0
            }
        }
        else{
            for (a=0;a<width;a++){
                ID = instance_create(xx-i,yy-a*64,obj_nonsolid) ID.image_index = 2 ID.image_speed = 0
            }
        }
        i+=64
    }
}
if turn = 2{//up
    xx=irandom((room_width/64)*64) - 64
    yy=0
    i=0
    while(i<room_height){
        if xx < room_width/2{
            for (a=0;a<width;a++){
                ID = instance_create(xx+a*64,yy+i,obj_nonsolid) ID.image_index = 2 ID.image_speed = 0
            }
        }
        else{
            for (a=0;a<width;a++){
                ID = instance_create(xx-a*64,yy+i,obj_nonsolid) ID.image_index = 2 ID.image_speed = 0
            }
        }
        i+=64
    }
}
if turn = 3{//down
    xx=irandom((room_width/64)*64) - 64
    yy=room_height-64
    i=0
    while(i<room_height){
        if xx < room_width/2{
            for (a=0;a<width;a++){
                ID = instance_create(xx+a*64,yy-i,obj_nonsolid) ID.image_index = 2 ID.image_speed = 0
            }
        }
        else{
            for (a=0;a<width;a++){
                ID = instance_create(xx-a*64,yy-i,obj_nonsolid) ID.image_index = 2 ID.image_speed = 0
            }
        }
        i+=64
    }
}


