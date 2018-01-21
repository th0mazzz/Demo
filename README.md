# Saturn Grades
SaturnGrades repository of our project

## The Team
Meredith Hu & Thomas Zhao

## Team Name
TheDreamCrushers

## Project Name
Saturn Grades (totally not shamelessly ripping off another popular grading system)

## Description
Saturn Grades is a (mostly) terminal based program and (mostly) GUI based program that tracks your academic record throughout your student career by adding classes and assignments. It will calculate your GPA as well as individual subject & subcategory averages, and store data for assignments in all subjects.

### How to use this program
For command line, please compile SaturnGrades.java. For GUI, please compile SaturnGradesGUI.java. To run either file, please enter "java <file name>", replacing file name with the version you wish to run.

Command Line: As a new user, the first page you come across when you open the program is the welcome page. In order to have a more detailed welcome screen, you are advised to update your name from the default "Unnamed". For more information on commands, type "help" as the keyword on the welcome screen. Keywords are what advance you to do various things in the program, as well as enter information for your subjects, subcategories, and assignments.

(For Mr. K: The command line functionality now has a "step-by-step" input rather than the "enter all parameters" input, which is supposed to make it less annoying to use. Just follow the rules and you should be fine!)

### Critical Features
Subjects
* Can have an infinite amount of categories, as long as the total weight of all the categories together is exactly 100%.
* When a subject has 0 categories, its average defaults to 100.0. If the sum of its subcategory weights is not 100.0, the subject will not compute an average, and GPA will not show.
* Subjects will always show their current averages when displayed.
* Subjects will automatically update the average if a subcategory or assignment is changed, added, or deleted.

Subcategories
* Can have an infinite amount of assignments, as long as the assignments have positive point worths.
* Can be deleted
* Can be edited (name and weight)
* Subcategories also always show their current averages when displayed(if you have a 95 test average or a 65 test average, youd want to know!!)
* Subcategories also automatically update the entire subcategory average if an assignment is changed, added, or deleted. So after getting back a test, you can input it and know how it directly affects your test average.
* If a subcategory has no assignments contained in it, its grade defaults to 100%

Assignments
* Can be deleted
* Can be edited (name, grade, date)

## Goals/What's Currently Done
### GUI Goals
making sure it works:
 - [x] Make a basic homepage
 - [x] Make a basic subjects page
 - [x] be able to switch between the pages
 - [x] Write a class for subject pages
 - [x] be able to go to any subject page and back
 - [x] write a class for subcategory pages
 - [x] be able to view subcategory pages and go back
 - [x] write a class for assignment pages
 - [x] be able to view assignment pages and go back

user input:
 - [x] be able to add subjects
 - [ ] be able to edit subject names
 - [x] be able to add subcategories in a subject
 - [ ] be able to edit subcategory names and weights
 - [x] be able to add assignments
 - [ ] be able to edit assignment grades and dates
 - [ ] be able to delete stuff
 - [ ] have the program yell at you if the subcats are invalid
 - [ ] have the averages show up for every subcategory and update every time a new assignment is added
 - [ ] averages show, automatic update for every subject
 - [ ] GPA show on homepage and be automatically updated

reaches:
 - [ ] write a quick summary view page
 - [ ] write a signup page for users
 - [ ] write a login page for users
 - [ ] write a user class
 - [ ] have "ghost" assignments that have just total points, but no points earned
 - [ ] be able to display ghost low end average, high end average, and actual average for a subject
 - [ ] be able to do that for subcategory as well

### Code Goals
basics:
 - [x] write subject, subcategory, and assignment classes
 - [x] write a wrapper class to run the program (like a user or SaturnGrades thing)
 - [x] write functions to check if subcats are valid in a subject
 - [x] write calcAverage functions

Command Line Functionality Goals
 - [x] be able to add subjects
 - [x] be able to edit subject names
 - [x] be able to add subcategories in a subject
 - [x] be able to edit subcategory names and weights
 - [x] be able to add assignments
 - [x] be able to edit assignment grades and dates
 - [x] be able to delete stuff
 - [x] have the program yell at you if the subcategory sum is not 100.0 for a subject
 - [x] have the averages show up for every subcategory and update every time a new assignment is added when displayed
 - [x] averages show when displayed, automatic update for every subject
 - [x] GPA show on welcome screen and be automatically updated
 - [x] get terminal functionality for summary keywords
 - [x] implement console (meaning program doesn't exit after every action)

reaches:
 - [ ] write a predictive average calculator based on future assignments and how much they would impact the grade
 - [ ] write a function that roasts users

## devlog
<<<<<<< HEAD
### 01/21/2018
* Okay. I think I'm done with this project. Finally. Command. Line. Functionality. Done. And now I have to study for two finals, hurray! Exhausted by this project whew... I doubt I'm going to implement anything else major
* Finished implementing console completely!
* Added exception catching for certain exceptions
* Merged branch console-feature with version3, deleted branch console-feature
* Updated the command line help page of the program
* I dont know whether Mr. K wants us to wipe the program's storage but I'll keep it there for now (I'm mentioning this because the welcome screen looks different with and without the default name saved)
* Ran the program (command line) in all possible scenarios I could think of and saw no errors or bugs so far. Will probably run it once more later on today to double check. Also, may merge version3 to master later on today as well.

### 01/20/2018 (Thomas)
* Finished remove! You can now remove subjects/subcategories/assignments!
* Basically started the update option in the main, got up to updating assignment names (finished with subject, subcategory, and user's name), have updating assignment grades/dates left I think
* Planning to work more tomorrow (by finishing update option for assignment), don't think we're going to add any more features after finishing this
* Touch up on little aspects of the SaturnGrades main function tmr

### 01/19/2018 (Thomas)
* Yes! I finished implementing adding everything!
* Fixed issue display averages when subcategories don't total to 100.0
* Wrote remove subject
* Overall, making slow but steady progress regarding this console stuff... it feels so much better than typing java SaturnGrades all the time!

### 01/18/2018 (Thomas)
* Tried to understand console better... and now I do!
* Implemented display and adding (partially)! Heck yeah!

### 01/18/2018 (Mer)
* is it just me, or are all these days blending together?
* removing works now! except for subcategory, but I'm too lazy to debug that right now
* also clarified the difference between repaint() and revalidate(). Tl;dr --> I need to call repaint too

### 01/17/2018 (Thomas)
* Created a new branch called console-feature to experiment with console input taking
* Experimented with it, familiarized with how it basically works, thinking on how to implement it because my main would need to be completely restructured (hence the new branch)
* Got quickview window working
>>>>>>> console-feature

### 01/17/2018 (Mer)
* Surprise surprise, I did work on the project today as well
* I rewrote the adding GUI stuff so it doesn't declare anonymous variables; I need the variable references since looking ahead, we're planning on implementing a login system so all the info contained in one instantiation of the program does need to be saved long term
* attempted to add removing, but it doesn't work. maybe I'll try using mouseListener instead of matching the strings of the button labels.

### 01/16/2018 (Mer)
* I always commit with (somewhat) accurate messages but forget to update the devlog here. Anyway, I made the assignment page display some basic info
* I also began implementing add functionality on the GUI
=======
### 01/16/2018 (Thomas)
* I got a quickView() function working that displays your GPA and your subject averages
* Implemented that into the command line so that if your name is "Unnamed" (which is default), then it will show the default welcome window. However, if you changed your name, it will display this cooler, more informative quickview window

### 01/15/2018 (Meredith)
* fixed the null pointer exception GUI bug from yesterday
* yes, I know it's 1:30 in the morning. sue me for not taking care of my health? you can now add stuff from the GUI. Gone are the days of manually instantiating stuff from the main! I can't delete things though, since writing that would require lots of parsing and implementing MouseListener- aka stuff I will save for the coming week. The demo version doesn't have to be the most feature rich!
* I also did a bunch of stuff today that made it look better, including: experimenting with BoxLayout, subdividing content panes into JPanels, and adding ScrollPanes! (I think I should commit more. I only commit about once a day, and I forget to mention ALL the things I've done over the course of a day's coding.)

### 01/14/18 (Meredith)
* you know how everyone thought tobacco was good for you in the 50's yeah, I'm convinced java's the new smoking, because debugging nullpointerexceptions and learning all of swing in two days was about as enjoyable as passing a kidney stone.
* I totally didn't make as much progress as I wanted to, I regret not using cardlayout and the GUI looks way uglier than I'd like it to be, but c'est la vie
* I finally wrote all the basic GUI classes (plus I had some other stuff to do today so progress was slow) so I'll get back to it tomorrow!

### 01/14/2018 (Thomas)
* I think I finished everything regarding command line functionality!
* Completed update command: you can now update names, weights, grades, dates!
* Made help screen more helpful
* There are a few things to touch up in note_to_self.txt but they're not suepr urgent or important so I shall now start my other project and HWs

### 01/13/2018 (Thomas)
* Command line if and else statements are SO TEDIOUS AND TIME CONSUMING
* I got MOST functionality regarding the command line:
adding/removing subjects, subcategories, and assignments
having a help page
having a display option that lets you choose between two displays
* I plan to implement the rest tomorrow so then I can start other HW and study for my two finals on Tuesday :(
* Oh it also seems Meredith made another branch and I wasn't told of that so I'm not sure which branch she wants me to commit this to so I'll push everything into minimal-working for now


### 01/13/2018 (Mer)
* Just a morning update from me: we chatted a bit about the improved backend design Thomas made last night, and it's perfectly fine. I should've communicated with Thomas more because for the past few days, I've been dismissive about really seeing any part of new code he was working on because I expended all my efforts into learning GUI. While it is taking a long time to learn GUI and create the sort of wrapper I want, I hope it'll pay off in the end and increase the program's usability.
* it's not the morning anymmore; I learned a bunch more GUI stuff today and concluded that the energy expended vs. how impressive this is going to look has a graph that resembles a square root curve; regarding actual progress made, I wrote a new class and fixed some straggling inconsistencies.
* oh yeah also I made a new branch because WOW like ABOUT TIME we move on from the minimal working version.

### 01/12/2018 (Thomas)
* Was able to get reading and writing functionality (absurdly long time to do)
* Reading function takes data from storage.txt (presumably from a previous write) and initializes the array with that data exactly how it was written
* Writing function writes the data in the array into storage.txt so then it can be read the next time the program is run
* Since Meredith and I are working in seperate spheres (her on GUI, and I on command line), our basic code has diverged quite a bit from each other's(entirely my fault, shoudl've communicated more as the backend dude); need to address this when we can

01/12/2018 (Mer)
* got the GUI working (ha! to people who said I couldn't)
* moved on from the minimal working version GUI and began writing second version, more updates soon to come

### 01/11/2018
* Created calcAverage() for SaturnGrades.java
* Wrote a toString() for SaturnGrades.java
* Made a relatively large driver for SaturnGrades.java and tested it for two new functions that were created and made functional today: displayBasic() and displayInformed()
* Self note: mostly done with the classes themselves, need to implement reading/writing first, then command line functionality, then (if Meredith gets it, otherwise not) GUI
* May need to add a few functions to support the reading/writing of files
* Minor tweaks here and there (forgot what minor tweaks though... heh...)
*(hi it's Meredith) I got a GUI to open but I still need it to switch between pages for minimal-working version

### 01/10/2018
* Created a new folder and revamped am currently revamping each individual class for command line functionality
* Revamping means changing old functions, making new ones, to make coding the command line code easier
* Meredith's trying to get GUI to work

### 01/09/2018
* Tried making some very basic GUI code late at night; there are some obstacles that need figuring out
* Created separate drivers for each .java file (mostly)

### 01/09/2018 (done together)
* wrote new toStrings for all classes- toString should display all information pertaining to an object
* also wrote some new accessor methods
* tested the subcategory function
* fixed a merge conflict/rebase error

### 01/08/2018
* Tried to make a navigational system through the terminal via the main function of User.java. I had to change the toString() of Subject.java (written by Meredith) to try and implement this functionality. However, I was only able to get ONE goal to work (that was "back") and everything else did not. I am doing this to because once you can navigate through the arrays via the terminal, I feel like that would vastly improve understanding navigating through GUI.

### 01/06/2018
* Vastly improved on Subcategory and Subject classes: many methods were written

### 01/05/2018
* Mostly in class discussion. We did some branch testing and decided to just work in one branch called minimal-working.
* Very basic Subcategory and Subject classes were written

### 01/04/2018
* The Minimal_Gui class was created. It contains a basic window with no functionality as of yet. It was created on branch "minimal_gui" and merged into master.
* The very basic Assignment class has been created, and is on the branch "assignment"




