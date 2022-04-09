package com.vine.alg.基本数据结构构造;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author 阿季
 * @date 2022-04-09 4:49 PM
 */
@Builder
@Data
@Setter
@NoArgsConstructor
public class LinkNode {
    private LinkNode pre;
    private LinkNode next;
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public LinkNode getPre() {
        return pre;
    }

    public void setPre(LinkNode pre) {
        this.pre = pre;
    }

    public LinkNode getNext() {
        return next;
    }

    public void setNext(LinkNode next) {
        this.next = next;
    }
}
