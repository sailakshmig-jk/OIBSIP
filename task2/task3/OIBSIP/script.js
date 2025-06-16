function convertTemperature() {
  const temp = parseFloat(document.getElementById('temperature').value);
  const type = document.getElementById('type').value;
  const resultBox = document.getElementById('result');

  if (isNaN(temp)) {
    resultBox.textContent = "Please enter a number";
    return;
  }

  let result = 0;
  let unit = "";

  if (type === "fahrenheit") {
    result = (temp - 32) * 5 / 9;
    unit = "°C";
  } else if (type === "celsius") {
    result = (temp * 9 / 5) + 32;
    unit = "°F";
  }

  resultBox.textContent = result.toFixed(4) + " " + unit;
}
