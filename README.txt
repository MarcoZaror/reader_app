README file for the reader app

Author: Marco Zaror
Course: COM6515
Date: January 2020

-----------------------
Objective and usage:   
-----------------------

The objective of the software is to allow the user to read a document loaded into the app and to learn some statistics about it.
For this purpose, it provides 3 buttons. One to load the document, another to show the text and another to show statistics abut the text.

-----------------------
Internal methodology:
-----------------------

The main window provides 3 buttons, to load the document, to display it and to show information about it.

Load the document:
When the load button is pressed, a DocumentLoader object is created. Then, a method from this object is called to read the document, determine whether it is a Poem, Play or Novel and create an object whith this previous definition (There is a parent document class and 3 subclasses; Poem, Play or Novel).

Display the document:
When the display button is pressed, a specific method of the document object is called to retrieve its content. Besides, the TextContent class is called, which shows the document in a pop up window in an easy way to read it.

Display the stats:
When the stats button is pressed, a specific method of the document object is called to retrieve stats about the document. Furthermore, the Stats class is called, which shows statistics in a pop up window about the document in an easy way to read them.

-----------------------
Software Structure:
-----------------------

To store the documents, 4 classes are provided. A Document parent class, and 3 subclasses; Poem, Play and Novel

DocumentViewer:
	- Main class of the software
	- Call DocumentViewerFrame class.

		DocumentViewerFrame: 
			- Contains the frame of the main window
			- Call DocumentViewerPanel class.

				DocumentViewerPanel:
					- Contain all the components inside the main window (buttons, panels, etc.) 
					- Contain the functionality of this components
					- Depending on the user intentions, could call the TextContent class or the Stats class

					TextContent:
						- Show the text in an pop up window
						- Provides a return button for usability

					Stats:
						- Show statistics about the text in an pop up window
						- Provides a return button for usability
		
DocumentLoader:
	- its objective is to read a file and create an object of the document class (or one of its subclasses) to be read later

CompareCounts:
	- Provide a comparator to allow the comparison of words by its frequency

Structure map:
|-----------------------------------------------------------------------------------------------------------------------|
|  |----------------|                                                                                                   |
|  | DocumentViewer |                                                                                                   |
|  |----------------|                                                     |------------|                                |
|         |                                        |----Show stats with-->|   Stats    |-----------|                    |
|       Has a                                      |                      |------------|           |                    |
|         |                                        |                                               |                    |
|  |---------------------|               |--------------------|             |-------------|        |                    |
|  | DocumentViewerFrame |---- Has a ----|DocumentViewerPanel |--Show text->| TextContent |   Retrieve stats            |
|  |---------------------|               |--------------------|    with     |-------------|       from                  |
|                                                |                              |                  |                    |
|                                              Use a                  Retrieve content from        |                    |
|                                                |                              |                  |                    |
|                                        |----------------|               |----------|             |                    |
|                                        | DocumentLoader |----Creates--->| Document |-------------|                    |
|                                        |----------------|               |----------|                                  |
|                                                                           ^^      ^                                   |
|                                                                          /  \      \                                  |
|                                                                         /    \      \                                 |
|                                                                      is a   is a    is a                              |
|                                                                       /        \      \                               |
|                                                                  |------| |-------| |------|                          |
|                                                                  | Poem | | Novel | | Play |                          |
|                                                                  |------| |-------| |------|                          |
|-----------------------------------------------------------------------------------------------------------------------| 
                                                                                   
-----------------------
Final observations:
-----------------------
- Both the display document and display stats actions shows a warning message if the file is not loaded, to aim usability. 
- For different design decisions (add instructions, size of the windows, allow to maximize the main window and where it is useful to add warning messages) a small case study was conduct (15 people) looking for enhance usability.
- When counting words, only spaces, parenthesis and punctuation signs were considered as a separators.
- For comparing words, a case insensitive comparator was used. This is because, in most cases, words in uppercase or in lowercase represent the same meaning.

