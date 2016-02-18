import os
#os.environ['SDL_VIDEO_WINDOW_POS'] = "%d,%d" % (7,30)
import pygame
from pygame.locals import *

def toggle_fullscreen():
    screen = pygame.display.get_surface()
    tmp = screen.convert()
    caption = pygame.display.get_caption()
    cursor = pygame.mouse.get_cursor()  # Duoas 16-04-2007 
    
    w,h = screen.get_width(),screen.get_height()
    flags = screen.get_flags()
    bits = screen.get_bitsize()
    
    #pygame.display.quit()
    pygame.display.init()
    
    screen = pygame.display.set_mode((w,h),flags^FULLSCREEN,bits)
    screen.blit(tmp,(0,0))
    pygame.display.set_caption(*caption)
 
    pygame.key.set_mods(0) #HACK: work-a-round for a SDL bug??
 
    pygame.mouse.set_cursor( *cursor )  # Duoas 16-04-2007
    
    return screen

pygame.init()
x = 30; y = 30
pl_width = 50; pl_height = 50
room_width = 1280; room_height = 800
screen = pygame.display.set_mode((room_width,room_height))
toggle_fullscreen()
done = False
is_blue = True
move_speed = 15
back_width = 64; back_height = 64
clock = pygame.time.Clock()
_image_library = {}
def get_image(path):
        global _image_library
        image = _image_library.get(path)
        if image == None:
                canonicalized_path = path.replace('/', os.sep).replace('\\', os.sep)
                image = pygame.image.load(canonicalized_path)
                _image_library[path] = image
        return image

background = pygame.image.load("grass.png")
# PLAYER MOVEMENT
def player_move(turn,speed):
    global x; global y
    for num in range(1,speed):
        if turn == "left" and x-num>0: x -= 1
        if turn == "right" and x+pl_width+num < room_width: x += 1
        if turn == "up" and y-num>0: y -= 1
        if turn == "down" and y+pl_height+num < room_height: y += 1

while not done:
        for event in pygame.event.get():
                if event.type == pygame.QUIT:
                        done = True
        #BACKGROUND DRAW
        back_x = 0
        while back_x < room_width:
                back_y = 0
                while back_y < room_height:
                        screen.blit(background, (back_x,back_y))
                        back_y += back_height
                back_x += back_width
        pressed = pygame.key.get_pressed()
        if pressed[pygame.K_UP]: player_move("up",move_speed)
        if pressed[pygame.K_DOWN]: player_move("down",move_speed)
        if pressed[pygame.K_LEFT]: player_move("left",move_speed)
        if pressed[pygame.K_RIGHT]: player_move("right",move_speed)
        if pressed[pygame.K_ESCAPE]: pygame.quit()
        
        screen.blit(get_image('ball.png'), (x, y))
        
        pygame.display.flip()
        clock.tick(120)

