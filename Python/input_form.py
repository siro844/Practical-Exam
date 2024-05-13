import tkinter as tk

def display_info():
    name = inp_name.get()
    age = inp_age.get()
    info_label.config(text=f"Name: {name}, Age: {age}")

def clear_inputs():
    inp_name.delete(0, tk.END)
    inp_age.delete(0, tk.END)
    info_label.config(text="")

window = tk.Tk()
window.title("Input form")
window.geometry("400x300")

label = tk.Label(window, text="name",width=20)
label.grid(row=0, column=0, columnspan=2)

inp_name = tk.Entry(window, width=30)
inp_name.grid(row=0, column=4, columnspan=2)

alabel = tk.Label(window, text="Age",width=20)
alabel.grid(row=4, column=0, columnspan=2)

inp_age = tk.Entry(window, width=30)
inp_age.grid(row=4, column=4, columnspan=2)
inp_age.bind('<Return>',evalu)

submit = tk.Button(window, text="Submit", width=8, command=display_info)
clear = tk.Button(window, text="Clear", width=8, command=clear_inputs)

submit.grid(row=5, column=0)
clear.grid(row=5, column=1)

info_label = tk.Label(window, text="", width=30)
info_label.grid(row=6, column=0, columnspan=6)
    
window.mainloop()
