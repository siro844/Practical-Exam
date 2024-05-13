import tkinter as tk

# Function to evaluate the expression in the entry field
def evaluate(event):
    try:
        result = eval(entry.get())
        label.config(text = "Result: " + str(result))
    except:
        label.config(text = "Invalid expression")

# Create a new tkinter window
window = tk.Tk()
window.title("Calculator")

# Create an entry field
entry = tk.Entry(window, width=20)
entry.bind('<Return>', evaluate)
entry.grid(row=0, column=0, columnspan=4)

# Create a label to display the result
label = tk.Label(window, text="Result:")
label.grid(row=1, column=0, columnspan=4)

# Create buttons for the digits and the operations
buttons = [
    '7', '8', '9', '+',
    '4', '5', '6', '-',
    '1', '2', '3', '*',
    '0', '.', '=', '/'
]

# Function to update the entry field when a button is pressed
def button_press(event):
    current = entry.get()
    text = event.widget.cget("text")
    if text == '=':
        try:
            result = eval(current)
            entry.delete(0, tk.END)
            entry.insert(tk.END, str(result))
        except:
            entry.delete(0, tk.END)
            entry.insert(tk.END, "Invalid expression")
    else:
        entry.insert(tk.END, text)

# Add the buttons to the window
for i in range(4):
    for j in range(4):
        button = tk.Button(window, text=buttons[i*4+j], width=5)
        button.grid(row=i+2, column=j)
        button.bind('<Button-1>', button_press)

# Start the tkinter event loop
window.mainloop()