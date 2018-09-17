# CEG4110-hw1
Andrew Sjoberg
Homework 1 in class CEG-4410

This Android app has two activities; one generates and displays a random color in RGB values and HTML color code. The second activity lets the user draw on the touch screen with any color they choose. You can switch between the first and second activity, and can clear all of the drawing in the second activity. I could not get the app to store files on its internal storage even though I created the necessary parent folders and the proper permission line in the app's manifest file.
This app uses two external resources, ColorSeekBar from rtugeek (https://github.com/rtugeek/ColorSeekBar), and HandDraw from gauravyadav673 (https://github.com/gauravyadav673/HandDraw). For both of these, I installed them by placing the root folder of ColorSeekBar and the folder touchDraw from HandDraw into the root folder of the project, and then imported both as modules. Then I needed to go to the project structure and make my main app dependent on both modules.
I organized this project by using two classes to distinguish the two activities. Most of the functionality comes from the onCreate() methods in those classes, although in part 2 I also had a save file method which gets called when either the save PNG or JPEG buttons get pressed (in order to have some code reuse). 
