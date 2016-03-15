i=0
type = argument0
how_many = argument1
while (i<how_many){
    rand_x = irandom(room_width/64)
    rand_y = irandom(room_height/64)
    rand_x = rand_x*64
    rand_y = rand_y*64
    if !collision_point(rand_x+32,rand_y+32,obj_solid,false,true){
        a = instance_create(rand_x,rand_y,obj_solid)
        a.image_index = type; a.image_speed = 0
        i++
    }
}
