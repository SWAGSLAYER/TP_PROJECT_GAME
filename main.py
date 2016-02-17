#import os
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
pl_width = 60; pl_height = 60
room_width = 1440; room_height = 900
screen = pygame.display.set_mode((room_width,room_height))
toggle_fullscreen()
done = False
is_blue = True
move_speed = 15
clock = pygame.time.Clock()

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
                if event.type == pygame.KEYDOWN and event.key == pygame.K_SPACE:
                        is_blue = not is_blue
        
        pressed = pygame.key.get_pressed()
        if pressed[pygame.K_UP]: player_move("up",move_speed)
        if pressed[pygame.K_DOWN]: player_move("down",move_speed)
        if pressed[pygame.K_LEFT]: player_move("left",move_speed)
        if pressed[pygame.K_RIGHT]: player_move("right",move_speed)
        if pressed[pygame.K_ESCAPE]: pygame.quit()
        
        screen.fill((0, 0, 0))
        if is_blue: color = (0, 128, 255)
        else: color = (255, 100, 0)
        pygame.draw.rect(screen, color, pygame.Rect(x, y, pl_width, pl_height))
        
        pygame.display.flip()
        clock.tick(60)
