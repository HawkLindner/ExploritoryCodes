OpenGL sample using GLFW + GLAD

This folder contains a minimal example that creates a window using GLFW and loads OpenGL function pointers with GLAD.

Files of interest:
- `src/main.cpp` - Creates a GLFW window, initializes GLAD, and runs a simple render loop.
- `src/glad.c` - GLAD loader source (already included in the project).
- `include/` - Contains `glad` headers and glfw headers (project-local includes).

Windows build notes

You need a compiled GLFW library for Windows (static or dynamic). You can build GLFW yourself or download prebuilt binaries.

MinGW (g++) example (adjust paths to your environment):

```powershell
# from repository root
g++ CPP\OpenGL\src\main.cpp CPP\OpenGL\src\glad.c -ICPP\OpenGL\include -L<path-to-glfw-lib> -lglfw3 -lopengl32 -lgdi32 -o OpenGLApp.exe
# If using dynamic glfw, ensure glfw3.dll is on PATH or in the same folder as the exe
```

MSVC (Developer Command Prompt) example:

```powershell
cl /EHsc /I CPP\OpenGL\include CPP\OpenGL\src\main.cpp CPP\OpenGL\src\glad.c /link <path\\to\\glfw3.lib> opengl32.lib
```

Notes:
- Replace `<path-to-glfw-lib>` or `<path\\to\\glfw3.lib>` with the directory containing the GLFW library on your machine.
- On Windows, link against `opengl32.lib` (MSVC) or `-lopengl32` (MinGW).
- If you prefer, use a package manager like vcpkg to install GLFW and link it via CMake or MSBuild.

If you want, I can add a simple `build.bat` for MinGW or a `CMakeLists.txt` to make building easier—tell me which you prefer.