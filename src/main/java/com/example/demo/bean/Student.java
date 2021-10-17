package com.example.demo.bean;

/**
 * <p>
 *
 * </p>
 *
 * @author astupidcoder
 * @since 2021-03-22
 */
//@Data
/*@Getter
@Setter
//@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)*/
public class Student {

    private static final long serialVersionUID = 1L;

    //    @TableId(value = "id", type = IdType.AUTO)
    public Integer id;

    public String name;

    public String address;

    public Integer age;


}
