# Realtor.com_Selenium_Automation
This project automates <a href="https://www.Realtor.com">Realtor.com</a> with the use of Selenium and testNg framework on Maven build to test basic validations.

Steps to run:

1) To run this project, install <a href="https://www.eclipse.org/downloads/">Eclipse (Preferably latest version)</a> , if you do not have one in your local machine.

2) In eclipse go to Windows >> Perspective >> Open Perspective >> Other >> Git

3) Then click on “clone a git  Repository and add the clone to this view.

4) Copy and paste this <a href="https://github.com/anjalimutha/Realtor.com_Selenium_Automation/">git repository link</a>  in URL >> click on next >> check directory >> click on Finish

5) Then Import the project from the local directory

6) Go to Windows >> Perspective >> Open Perspective >> Other >> Java Browsing

7) In testNg.xml, you can update browser as "chrome" or "firefox" or "edge" and click on run

------------------------------------------------------------------------------------------------------------------

Noticeable features about the project:
1) This project makes use of dynamic xpath at times where the requirement is to click 2nd element or retrieve 2nd element (where value of n can be any number which will provide appropriate result for nth number of search result)

2) This project makes use of Page Object Model using Page Factory. Use of page factory reduces the redundancy of code.

3) This use of page object makes this code maintainable. Users can anytime add objects to the pages

4) Some widely used functions are created in utils java file which are universal to use. For example click on any element and wait, or wait for title of any page, etc.

5) This project uses a unique feature from testNg which is Assert.assertTrue/False/Equals which verifies boolean condition and if it is not met, it will throw error message. This feature is very useful in debugging the exact line of code for error. This makes debugging easy as it will skip the part of method post failure and jump to next method if the method failed.

6) If a method fails, this code captures the screenshot of the failed page in a new folder ScreenShots and thus it helps in debugging the failure.
