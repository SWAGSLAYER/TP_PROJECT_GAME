length = irandom(6)+5;
width = irandom(6)+5;
i=0
xx=0
yy=0

do{
    xx = irandom(room_width/64)*64
    yy = irandom(room_height/64)*64
}until(!place_meeting(xx,yy,obj_nonsolid))

for(i=0;i<length*64;i+=64){
    if !collision_rectangle(xx+i,yy,xx+i+64,yy+64,obj_nonsolid,false,true){
        a = instance_create(xx+i,yy,obj_nonsolid) a.image_index = 2 a.image_speed = 0
    }  
}

