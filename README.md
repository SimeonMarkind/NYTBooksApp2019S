 Welcome to my Simeon Markind's final project for Android App Development. 

My app consists of three activities and allows users to search for books using the NYTimes Books API.

###Contents

My Mainactivity allows users to search for books either by title/author or to generate a set of books based on the many booklists that NYTimes maintains. The books that are returned by the API are displayed in cards set into a Recylcerview on the lower portion of the Activity. Books that are found by author/title have the cover image populated using the https://covers.openlibrary.org/b/isbn/ API. (When a book is returned from the NYT API, the ISBN data is taken and a second API call is made to get the cover image, not all books have cover images.) Books that are found using the NYT booklists have cover images that are stored in a separate API by the NYTimes itself, and so all books in the NYT booklists will have cover images associated with them. (To see how these two types of books are handled see ReviewAdapter and BookListAdapter files respectively.) Each card displaying a book includes a button to add to the reading list, this populates a Room database with information about the selected book.

My ReadingListActivity shows the user the current books stored in their chosen reading list. Each BookEntry is displayed in a card, and the Activity shows these cards in a recyclcerview. If a user has read a book, pushing the "I Read it!" button will delete that entry from the Room database. 

My Settings Activity allows for some customization of the app. The Name field lets a user input their name for the app. Inputting a name updates the app's SharedPreferences and allows for updating the text in the Book cards. (If a valid name is stored, the text on the buttons in the MainActivity is customized: "Add to [USER's] Reading List"). The favorite author button does not change app behavior, but simply illustrates usage of the SharedPreferences object as the answer is stored in text. Additionally, toggling the Night Mode switch will turn on/off Night Mode for the app. I use SharedPreferences to check the Night Mode status of the app in each activity and then to set Night Mode as on or off accordingly. [Note: this is not the best method for toggling night mode in Android, I am aware of that, but use this method to utilize SharedPreferences in greater detail since that is an App requirement.]

###Usage:

Upon first opening the app, a user will be shown the settings page. Once settings are updated and saved, (FAB in the bottom right corner), user will be taken to the MainActivity. Here books can be searched via title and/or author or a whole booklist can be returned. Users can then add books they are interested in to their booklist. The bottom right FAB in the MainActivity takes users to the ReadingListActivity which shows users the current list of books they selected. On this page one can delete entries in their booklist. The bottom right FAB on this activity, the search icon, takes users back to the MainActivity to search for more books. Access to the Settings Activity is through the options menu in the top right.