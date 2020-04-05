package com.nearpe.zipcode.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "news_feed")
public class NewsFeed {

    @Id
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "user_id", nullable = false)
    private long userId;

    @Column(name = "post_id", nullable = false)
    private long postId;

    public long getPostId1() {
        return postId;
    }
}
