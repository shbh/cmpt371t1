# Introduction #

Test coverage, traceability matrix.


# Details #

## Traceability Matrix ##
|Business Requirements| Functional Requirements | TC(1) | TC(2) | TC(3) | TC(4) | TC(5) | TC(6) | TC(7) |
|:--------------------|:------------------------|:------|:------|:------|:------|:------|:------|:------|
| 1                   |Light to orb connection  | x     |       | x     |       |       |       |       |
| 2                   |Light to mirror connection  | x     | x     |       |       |       |       |       |
| 3                   |White Light to prism refraction  | x     |  x    |       |       |       |       |       |
| 4                   |Mirror rotation          |       | x     |       |       |       |       |       |
| 5                   |Eraser functionality     | x     |       |       |       |       |       |       |
| 6                   |User time record         |       |       |       | x     |       | x     |       |
| 7                   |Sound effects/BG music   |       |       |       |       |       |       |x      |
| 8                   |Level transition         |       |       |       |       | x     |       |       |
| 9                   |Pause action             |       |       |       |       | x     |       |       |
| 10                  |Change in orientation    |       |       |       |       | x     |       |       |
| 11                  |Smooth playability       |       |       |       |       |       | x     |       |

## Test Cases: ##

  1. Light to obstacle collision
  1. Object interaction/function
  1. Object to obstacle collision
  1. User statistics registration
  1. User transition between states, saved menu, resume
  1. System under stress
  1. User game configuration and input

## Code related to Test Cases: ##

**Light to obstacle collision**

ca.sandstorm.luminance.test.gameobject
  * BoxTest
  * LightTest
  * MirrorTest
  * PrismTest
  * ReceptorTest
ca.sandstorm.luminance.test.gametools
  * EraserTest
  * LightPathTest
  * MirrorToolTest
  * PrismToolTest
  * ToolBeltTest
ca.sandstorm.luminance.test.math
  * CollidersTest
  * LerpTest
  * PlaneTest
  * RayTest

**Object interaction/function**

ca.sandstorm.luminance.test.gameobject
  * BoxTest
  * LightTest
  * MirrorTest
  * PrismTest
  * ReceptorTest
ca.sandstorm.luminance.test.gametools
  * EraserTest
  * LightPathTest
  * MirrorToolTest
  * PrismToolTest
  * ToolBeltTest

**Object to obstacle collision**

ca.sandstorm.luminance.test.gameobject
  * BoxTest
  * LightTest
  * MirrorTest
  * PrismTest
  * ReceptorTest
ca.sandstorm.luminance.test.gametools
  * EraserTest
  * LightPathTest
  * MirrorToolTest
  * PrismToolTest
  * ToolBeltTest
ca.sandstorm.luminance.test.math
  * CollidersTest
  * LerpTest
  * PlaneTest
  * RayTest

**User statistics registration**

  * Simple Logging Facade for Java

**User transition between states, saved menu, resume**

ca.sandstorm.luminance.gamelogic
  * GameStateTest
  * GameRendererTest
  * MenuStateTest

**System under stress
  * UseCaseTest
  * Test case 6 GUI testing**

**User game configuration and input**

ca.sandstorm.luminance.gamelogic
  * GameStateTest

ca.sandstorm.luminance.input
  * InputButtonTest
  * InputKeyboardTest
  * InputSystemTest
  * GUIManagerTest

## Functional Requirements: ##

  * Light to orb connection
  * Light to mirror connection
  * White Light to prism refraction
  * Mirror rotation
  * Eraser functionality
  * User time record
  * Sound effects/BG music
  * Level transition
  * Pause action
  * Change in Orientation
  * Smooth playability

Premise of game:

  * Player is trying to connect light to orb
  * Player is trying refract around obstacles


Features of game:

  * Phone Rotation possible
  * Music and sound effects
  * 3D Zoom in Zoom out
