repeat(argument0){

//gen lake

build_count = irandom(30)+20
build_object = obj_solid
for(i=0;i<build_count;i++){
    xx = irandom(room_width/64)*64
    yy = irandom(room_height/64)*64
    if !collision_rectangle(xx,yy,xx+64,yy+64,build_object,false,true){
        a = instance_create(xx,yy,build_object) a.image_index=0 a.image_speed=0
    }   
}

}
