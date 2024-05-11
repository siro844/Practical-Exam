from tkinter import *

# Instantiates a window
window=Tk()
x=IntVar()
window.geometry("400x500")
window.title("Lame Ass")
window.config(background="black")


#Label

# label=Label(window,
#             text="Python Gui is Lame",
#             font=('Arial',20,'bold'),
#             padx=10,
#             pady=10
#             )
# # Default top center placement
# label.pack()

#To place at will
# label.place(x=100,y=100)

# button 

def click():
    print("You clicked the button")
# def submit():
#     print(entry.get())

# button=Button(window,text="Submit!",command=submit,font=("Comic Sans",18))
# # button.place(x=150,y=50)
# button.pack(side=RIGHT)
# #state=ACTIVE/DISABLED

# def delete():
#     entry.delete(0,END)
# button=Button(window,text=" Delete",command=delete,font=("Comic Sans",18))
# # button.place(x=150,y=50)
# button.pack(side=RIGHT)



#entry

#show replaces all words with *
# entry=Entry(window , font=("Arial",20),show="*")
# entry.pack(side=LEFT)


#Check Button

# def display():
#     if(x.get()==1):
#         print("Ohhh")
#     else:
#         print("Nooooo")
# check_button=Checkbutton(window,text="Yes",variable=x,onvalue=1,command=display).grid(row=3,column=9)

# for i in range(1,10):
#     print(i)


#Textarea

# text=Text(window)
# text.grid(row=3,column=4)


# KEY Events


# window.bind(event,function)
# def doSomething(event):
#     #print("You pressed :" + event.keysym)
#     label.config(text=event.keysym)
# window.bind("<Key>",doSomething)
# label=Label()
# label.pack()


# Mouse Events
def mouseClick(event):
    print("You did")
window.bind("<Button-1>",mouseClick)

#Places window on screen
window.mainloop()