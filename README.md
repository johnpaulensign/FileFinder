# FileFinder

## Running

1. Import files into IDE
1. Update/configure `App.java` to set directory and rules
1. Build/run project

## Rule Examples

```java
Rule pdfExtension = NameRule.get(".pdf");
Rule txtExtension = NameRule.get(".txt");

Rule smallSize = SizeRule.get(10);
Rule mediumSize = SizeRule.get(10, SizeRule.KB);
Rule largeSize = SizeRule.get(10, SizeRule.MB);

Rule lastModified = ModifyRule.get(2020, 12, 1, 0, 0, 0);
```

## Rule Usage Examples

### Find all text/pdf files that were modified since Dec. 1, 2020

```java
FileFinder ff = new FileFinder("/");

Rule pdfExtension = NameRule.get(".pdf");
Rule txtExtension = NameRule.get(".txt");

Rule lastModified = ModifyRule.get(2020, 12, 1, 0, 0, 0);

ff.filter.or(pdfExtension, txtExtension).and(lastModified);
```

### Find all pdf files that are larger than 2 MB

```java
FileFinder ff = new FileFinder("/");

Rule pdfExtension = NameRule.get(".pdf");
Rule size = SizeRule.get(2, SizeRule.MB);

ff.filter.and(pdfExtension, size);
```

### Find all jpg files that contain cat, dog, or bird **and** are greater than 1 MB _or_ modified after Oct. 31, 2020

```java
FileFinder ff = new FileFinder("/");

Rule extension = NameRule.get(".jpg");

Rule cat = NameRule.get("cat");
Rule dog = NameRule.get("dog");
Rule bird = NameRule.get("bird");

Rule size = SizeRule.get(1, SizeRule.MB);
Rule lastModified = ModifyRule.get(2020, 10, 31, 23, 59, 59);

ff.filter.and(extension).or(cat, dog, bird).or(size, lastModified);
```
