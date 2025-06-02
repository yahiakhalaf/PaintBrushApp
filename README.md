# PaintBrushApp

## Overview

**PaintBrushApp** is a Java-based digital painting application implemented as an applet. It provides users with a simple yet effective interface for creating digital artwork, supporting a variety of drawing tools including freehand, geometric shapes (lines, rectangles, ovals), and an eraser. The application offers color selection, fill and dotted line options, undo functionality, canvas clearing, and image import/export as PNG.

---

## Features

- **Drawing Tools**: Freehand, Line, Rectangle, Oval, and Eraser  
- **Color Selection**: Predefined color palette (e.g., Red, Green, Blue)  
- **Shape Customization**: Toggle fill and dotted styles  
- **Canvas Operations**:  
  - Undo last shape  
  - Clear canvas  
  - Save artwork as a PNG file  
  - Open existing PNG images  
- **Graphical Interface**: Built using Java AWT for a responsive GUI

---

## Project Structure

```
PaintBrushApp/
│
├── project.policy         # Java policy file for applet permissions
├── project.html           # HTML file to embed the applet
├── Main.java              # Application entry point
│
├── shapes/                # Drawing tool classes
│   ├── Shape.java             # Abstract base class for shapes
│   ├── EraserShape.java       # Eraser tool implementation
│   ├── FreeHandShape.java     # Freehand drawing
│   ├── LineShape.java         # Line drawing with optional dotted style
│   ├── OvalShape.java         # Oval drawing with fill/dotted styles
│   └── RectangleShape.java    # Rectangle drawing with fill/dotted styles
│
└── paint/
    └── PaintBrush.java     # Core applet logic and GUI handling
```

---

## System Requirements

- Java Development Kit (JDK) 8 or higher  
- Java Runtime Environment (JRE)  

---

## Installation & Setup

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/yahiakhalaf/PaintBrushApp.git
   cd PaintBrushApp
   ```

2. **Compile the Source Code**:
   ```bash
   javac -d . shapes/*.java paint/*.java Main.java
   ```

3. **Configure the Applet**:
   - Open `project.html` and insert the following applet tag:
     ```html
     <applet code="paint.PaintBrush" width="1920" height="1080"></applet>
     ```
   - Ensure `project.policy` exists in the root directory to grant necessary permissions.

4. **Run the Applet**:
   - Using an applet viewer:
     ```bash
     appletviewer project.html
     ```
   - Alternatively, host `project.html` on a local server and access via a compatible browser.

---

## Usage Instructions

1. Launch the application using an applet viewer or browser.  
2. Use the toolbar to:
   - Select a drawing tool (Freehand, Line, Rectangle, Oval, Eraser)
   - Choose a color (Red, Green, Blue, etc.)
   - Toggle "Filled" or "Dotted" using checkboxes  
3. Draw by clicking and dragging on the canvas.  
4. Additional controls:
   - **Undo**: Remove the last drawn shape  
   - **Clear All**: Reset the entire canvas  
   - **Save**: Export the drawing as a PNG file  
   - **Open**: Load an existing image

---


## License

This project is licensed under the [MIT License](LICENSE).


