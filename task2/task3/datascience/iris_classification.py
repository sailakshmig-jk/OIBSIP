# iris_classification.py

# Step 1: Import necessary libraries
import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns

from sklearn.datasets import load_iris
from sklearn.model_selection import train_test_split
from sklearn.tree import DecisionTreeClassifier
from sklearn.metrics import classification_report, accuracy_score

# Step 2: Load the iris dataset
iris = load_iris()
df = pd.DataFrame(data=iris.data, columns=iris.feature_names)
df['species'] = iris.target
df['species'] = df['species'].map({0: 'setosa', 1: 'versicolor', 2: 'virginica'})

# Step 3: Explore the dataset
print("🔍 First 5 rows of data:")
print(df.head())
print("\n📊 Dataset summary:")
print(df.describe())

# Optional Visualization
sns.pairplot(df, hue='species')
plt.title("Iris Flower Features by Species")
plt.show()

# Step 4: Split data for training and testing
X = df.drop('species', axis=1)
y = df['species']

X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.3, random_state=42)

# Step 5: Create and train the model
model = DecisionTreeClassifier()
model.fit(X_train, y_train)

# Step 6: Predict and evaluate
y_pred = model.predict(X_test)

print("\n✅ Accuracy of the model:", accuracy_score(y_test, y_pred))
print("\n📝 Classification Report:")
print(classification_report(y_test, y_pred))
