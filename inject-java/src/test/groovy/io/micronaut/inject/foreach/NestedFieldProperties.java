package io.micronaut.inject.foreach;

import io.micronaut.context.annotation.ConfigurationProperties;
import io.micronaut.context.annotation.EachProperty;

import java.util.List;

@ConfigurationProperties("outer-field-nested")
public class NestedFieldProperties {


    private String name;
    protected List<NestedFieldProperties.InnerEach> inner;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @EachProperty("inner")
    public static class InnerEach {
        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        private Integer age;
        protected List<NestedInnerEach> nested;

        @EachProperty("nested")
        public static class NestedInnerEach {
            private String name;

            public void setName(String name) {
                this.name = name;
            }

            public String getName() {
                return name;
            }
        }

    }
}
