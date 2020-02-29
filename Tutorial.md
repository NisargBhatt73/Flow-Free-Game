# 1.Components used in making  game

      We have built the game using the java interface. Java provides many graphic classes such as java swing , java applet , mouse event listener, action listener etc. some of them is used by us in this project are listed below

Java swing
Java applets
Java awt event listener
## 1.1java swing
 We used the JFrame component of java swing. For using JFrame we have imported the library “javax.swing.jframe”. Jframe works like the main window   where components like labels, buttons, text fields are added to create a graphical user interface.The reason why we used the java swing is that it does not require calling the paint method every time when we perform some action like mouse clicked ,mouse dragged etc.

## 1.2java applet

For using the java applet we have to import the library “java.applet.*”. This will import all the methods available in the applet class. We have used the following functions of the applet class.
drawRect() – this method is used to draw the rectangle at a particularposition  and of specified length and breadth. The syntax is as follow 
                          g.drawRect(int x, int y, int width, int height)
fillRect()- This method is same as the above method but the difference is that it will color the given rectangle with the specified color.
                         g.FillRect(int x, int y, int width , int height)

FillOval()- this method is used to draw a colored oval circumscribed in a  rectangle at a particular  position  and of specified length and breadth. The syntax is as follow 
                          g.FillOval(int x, int y, int width, int height)

## 1.3java awt event listener
When we are working with the java applet  we perform the many action on the applet window such as clicking on the button, scroll the window etc. Inorder  to capture that type of the action the java provide the awt event package which includes the different types of event class. In our game we need to impletment the suitable event which reponds to the mouseclick ,mouse dragged and mouse released. This can implement by simply inherits  mouse motion listener and mouse listener. And following methods are used of this interface


mouseClicked()- This is an abstract method of an interface mouse action listener. This will give the coordinates where the mouse is clicked. The following methods is used to get the coordinates 
                                g.getX()
                                g.getY()   
where g is an  instance of Graphics class.
mouseDragged()-  This is an abstract method of an interface mouse motion listener. This will give the coordinates when the mouse is dragged. The following methods is used to get the coordinates
                                            g.getX()
                                            g.getY()   
# 2Making the Layout of game
In these game first we have to adjust the background of the game. First we have to make the background of game. Then we  have to make the square grid and the border of the square grid. Then we have  to place the different dots at specified location and the color of the dots.
## 2.1 setting the background 
In java swing we have the different methods to set the background of the applet window. The following method we have used to set the color of the background,
## 2.2 making the square grid
Then the square grid is to be made with the help of the drawrect() method. The following is the syntax of the drawrect method
                     
                                 g.drawRect(int x, int y, int width, int height)
here int x and int y indicates the starting coordinates of rectangle inthe applet window.
# 3. How to connect two dots

Now after making the layout of the game we are ready to play the level 1 of the game. First we have select the particular dot from which we have to start dragging for that we have use the event listener.
## 3.2 mouseclicked (Event e)
This method is invoked whenever we clicked on the applet window. The following two method are there which give the coordinates of the cursor were we clicked.
                                     g.getX()
                                     g.getY()   
where g is an  instance of Graphics class.
After getting the  coordinate of the cell of the square grid we fetch which color dot is present and store it in a arraylist. This arraylist is two dimensional arraylist which contains the cell which are dragged of particular color.
## 3.3 mousedragged(Event e) 
This method is invoked whenever we dragged the mouse on the applet window. This method is used to draw the pipe between two dots. This can be done with the help of arraylist and cell visible array.

                               
                                           setBackground(Color.YELLOW); 
