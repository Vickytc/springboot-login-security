package com.example.security.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Role implements Serializable {

  /**
   * 角色主键
   */
  private Long id;

  /**
   * 角色名称
   */
  private String name;

}
