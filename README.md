# Artjoker Database Orm

Simple Orm which generates database contracts for android app. This solution based on apt code generation and can be used for your own solutions which can help you to avoid a lot of boilerplate code.

More information about code generation: http://docs.oracle.com/javase/1.5.0/docs/guide/apt/GettingStarted.html

APT for android: http://code.neenbedankt.com/gradle-android-apt-plugin/

You can find generated sources under your /build directory :

<img src="https://github.com/artjoker/database-orm/blob/master/sample.jpg?raw=true" width="386" height="214" />

# Usage

```java

@DatabaseTable(name = "sample_table")
public class DataModel {

    @DatabaseField(name = "id")
    private long id;

    @DatabaseField(name = "name")
    private String name;

}
```
## LICENSE

Copyright (c) 2016-present, Artjoker.

Licensed under the MIT License ;

The MIT License

Copyright (c) Artjoker. http://artjoker.net

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.