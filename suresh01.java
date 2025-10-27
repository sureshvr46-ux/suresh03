document.addEventListener("DOMContentLoaded", () => {
  const usernameInput = document.getElementById("username");
  const themeColorInput = document.getElementById("themeColor");
  const fontSelect = document.getElementById("fontSelect");
  const layoutSelect = document.getElementById("layout");
  const preview = document.getElementById("preview");
  const previewUsername = document.getElementById("previewUsername");
  const saveBtn = document.getElementById("saveBtn");

  // Live preview updates
  function updatePreview() {
    const color = themeColorInput.value;
    const font = fontSelect.value;
    const layout = layoutSelect.value;
    const username = usernameInput.value || "User";

    preview.style.backgroundColor = color;
    preview.style.fontFamily = font;
    preview.style.width = layout === "boxed" ? "50%" : "100%";
    previewUsername.textContent = `Welcome, ${username}!`;
  }

  // Add listeners
  usernameInput.addEventListener("input", updatePreview);
  themeColorInput.addEventListener("input", updatePreview);
  fontSelect.addEventListener("change", updatePreview);
  layoutSelect.addEventListener("change", updatePreview);

  // Save user data to localStorage
  saveBtn.addEventListener("click", () => {
    const userData = {
      username: usernameInput.value,
      themeColor: themeColorInput.value,
      font: fontSelect.value,
      layout: layoutSelect.value,
    };

    localStorage.setItem("userThemeData", JSON.stringify(userData));
    alert("Your settings have been saved!");
  });

  // Load saved data
  const savedData = JSON.parse(localStorage.getItem("userThemeData"));
  if (savedData) {
    usernameInput.value = savedData.username;
    themeColorInput.value = savedData.themeColor;
    fontSelect.value = savedData.font;
    layoutSelect.value = savedData.layout;
    updatePreview();
  }
});