# Realtor.com_Selenium_Automation
This project automates <a href="https://www.Realtor.com">Realtor.com</a> with the use of Selenium and testNg framework on Maven build to test basic validations.

#Steps to run:

1) To run this project, install <a href="https://www.eclipse.org/downloads/">Eclipse (Preferably latest version)</a> , if you do not have one in your local machine.

2) In eclipse go to Windows >> Perspective >> Open Perspective >> Other >> Git

3) Then click on “clone a git  Repository and add the clone to this view.

4) Copy and paste this <a href="https://github.com/anjalimutha/Realtor.com_Selenium_Automation/">git repository link</a>  in URL >> click on next >> check directory >> click on Finish

5) Then Import the project from the local directory

6) Go to Windows >> Perspective >> Open Perspective >> Other >> Java Browsing

7) In testNg.xml, you can update browser as "chrome" or "firefox" or "edge" and click on run

------------------------------------------------------------------------------------------------------------------

#Noticeable features about the project:

1) This project makes use of dynamic xpath on runtime where the if requirement is to click nth element or retrieve nth element (where value of n can be any number (1, 2, 3, etc.) it will provide appropriate runtime xpath for nth number of search result. Thus, any element in DOM can be retrieved on runtime.

2) There were few elements whose ids/class names were dynamic and were changing in each run. This code handles it and uses xpath which is dynamic enough to capture the changing ids and class names in DOM structure.

3) This project makes use of Page Object Model using Page Factory. Use of page factory reduces the redundancy of code.

4) This use of page object makes this code maintainable. Users can anytime add objects to the pages.

5) Some widely used functions are created in utils java file which are universal to use. For example click on any element and wait, or wait for title of any page, etc.

6) This project uses a unique feature from testNg which is Assert.assertTrue/False/Equals which verifies boolean condition and if it is not met, it will throw error message. This feature is very useful in debugging the exact line of code for error. This makes debugging easy as it will skip the part of method post failure and jump to next method if the method failed.

7) If a method fails, this code captures the screenshot of the failed page in a new folder ScreenShots and thus it helps in debugging the failure.

8) This code is easy to read by any non technical person. The main script lies in src/test/Java/testScripts which is well commented and utilizes self explanatory method names which can be understood by anyone. The best part is that it's logic lies behind in the src/main folder comprising of java code to handle these functions. 
