# Saturn Grades
SaturnGrades repository of our project

## The Team
Meredith Hu & Thomas Zhao

## Team Name
TheDreamCrushers

## Project Name
Saturn Grades (totally not shamelessly ripping off another popular grading system)

## Description
Create a grade calculator that can calculate an estimated GPA based on given class, subcategory, and assignment grade inputs. Designed with students as users in mind. Will (hopefully) have more features.
### how to use this program
hopefully, we'll have programmed directions into the command line version AND the GUI version, but, in case I drown in coffee and die this weekend or defenestrate myself from the excessive Java exposure, I'll put the directions here
### Critical Features
Subjects
* can have an infinite amount of categories, as long as the total weight of all the categories together is exactly 100%.
* When a subject has 0 categories, it does not compute an average. Same for if the weight of all its categories does not add up to 100.
* Subjects will always show their current averages
* Subjects will automatically update the average if a subcategory or assignment is changed, added, or deleted

Subcategories
* can have an infinite amount of assignments, as long as the assignments have positive point worths.
* can be deleted
* can be edited (name and weight)
* Subcategories also always show their current averages (if you have a 95 test average or a 65 test average, youd want to know!!)
* Subcategories also automatically update the entire subcategory average if an assignment is changed, added, or deleted. So after getting back a test, you can input it and know how it directly affects your test average.
* If a subcategory has no assignments contained in it, its grade defaults to 100%

Assignments
* can be deleted
* Assignments can be assigned in advance- meaning the user does not input a points earned value, but does input a points worth value. The application uses these in advance assignments to predict averages, a to be added later feature.
* can be edited (name, points, etc.)

## Goals/What's Currently Done
### GUI Goals
making sure it works:
 - [x] Make a basic homepage
 - [x] Make a basic subjects page
 - [x] be able to switch between the pages
 - [x] Write a class for subject pages
 - [x] be able to go to any subject page and back
 - [x] write a class for subcategory pages
 - [ ] be able to view subcategory pages and go back
 - [ ] write a class for assignment pages
 - [ ] be able to view assignment pages and go back

user input:
 - [ ] be able to add and delete subjects
 - [ ] be able to add and delete subcategories in a subject, and have the program yell at you if the cats are invalid
 - [ ] be able to add and delete assignments
 - [ ] have the averages show up for every subcategory and update every time a new assignment is added
 - [ ] averages show, automatic update for every subject
 - [ ] GPA show on homepage and be automatically updated

reaches:
 - [ ] write a quick summary view page

### Code Goals
basics:
 - [x] write subject, subcategory, and assignment classes
 - [x] write a wrapper class to run the program (like a user or SaturnGrades thing)
 - [x] write functions to check if subcats are valid in a subject
 - [x] write calcAverage functions

command line functionality
 - [x] get terminal functionality for summary keywords
 - [ ] be able to handle user input of subject names and grades and things like that

reaches:
 - [ ] write a predictive average calculator based on future assignments and how much they would impact the grade
 - [ ] write a function that roasts users

## devlog
### 01/13/18 (Mer)
* Just a morning update from me: we chatted a bit about the improved backend design Thomas made last night, and it's perfectly fine. I should've communicated with Thomas more because for the past few days, I've been dismissive about really seeing any part of new code he was working on because I expended all my efforts into learning GUI. While it is taking a long time to learn GUI and create the sort of wrapper I want, I hope it'll pay off in the end and increase the program's usability.
* it's not the morning anymmore; I learned a bunch more GUI stuff today and concluded that the energy expended vs. how impressive this is going to look has a graph that resembles a square root curve; regarding actual progress made, I wrote a new class and fixed some straggling inconsistencies.

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




